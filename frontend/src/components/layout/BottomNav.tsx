import { useLocation, useNavigate } from 'react-router-dom'
import { Home, BarChart3, Dumbbell, Mountain } from 'lucide-react'

const tabs = [
  { path: '/', icon: Home, label: 'Home' },
  { path: '/statistics', icon: BarChart3, label: 'Statistics' },
  { path: '/training', icon: Dumbbell, label: 'Training' },
  { path: '/climbing', icon: Mountain, label: 'Climbing' },
]

export function BottomNav() {
  const location = useLocation()
  const navigate = useNavigate()

  const isActive = (path: string) =>
    path === '/' ? location.pathname === '/' : location.pathname.startsWith(path)

  return (
    <nav className="fixed bottom-0 left-0 right-0 bg-white border-t border-gray-100 pb-[env(safe-area-inset-bottom)]">
      <div className="flex justify-around items-center h-16 max-w-lg mx-auto">
        {tabs.map(tab => {
          const active = isActive(tab.path)
          return (
            <button
              key={tab.path}
              onClick={() => navigate(tab.path)}
              className="flex flex-col items-center gap-1 py-1"
            >
              <div className={`p-1.5 rounded-full transition-colors ${active ? 'bg-primary' : ''}`}>
                <tab.icon className={`w-5 h-5 ${active ? 'text-white' : 'text-text-secondary'}`} />
              </div>
              <span className={`text-[10px] font-medium ${active ? 'text-primary' : 'text-text-secondary'}`}>
                {tab.label}
              </span>
            </button>
          )
        })}
      </div>
    </nav>
  )
}
