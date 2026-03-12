import { ChevronRight } from 'lucide-react'

interface ListItemProps {
  title: string
  subtitle?: string
  onClick?: () => void
}

export function ListItem({ title, subtitle, onClick }: ListItemProps) {
  return (
    <button
      onClick={onClick}
      className="flex items-center w-full bg-card rounded-2xl p-4 shadow-sm mb-3 active:scale-[0.98] transition-transform"
    >
      <div className="flex-1 text-left">
        <div className="text-sm font-semibold text-text">{title}</div>
        {subtitle && <div className="text-xs text-text-secondary mt-0.5">{subtitle}</div>}
      </div>
      <ChevronRight className="w-4 h-4 text-text-secondary" />
    </button>
  )
}
