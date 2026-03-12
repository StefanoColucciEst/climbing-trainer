import { useNavigate } from 'react-router-dom'
import { ArrowLeft, Pencil } from 'lucide-react'

interface PageHeaderProps {
  title: string
  onEdit?: () => void
}

export function PageHeader({ title, onEdit }: PageHeaderProps) {
  const navigate = useNavigate()

  return (
    <header className="flex items-center justify-between py-4">
      <button onClick={() => navigate(-1)} className="p-2 -ml-2 active:scale-90 transition-transform">
        <ArrowLeft className="w-5 h-5 text-text" />
      </button>
      <h1 className="text-lg font-bold text-text">{title}</h1>
      {onEdit ? (
        <button onClick={onEdit} className="p-2 -mr-2 active:scale-90 transition-transform">
          <Pencil className="w-4 h-4 text-text-secondary" />
        </button>
      ) : (
        <div className="w-9" />
      )}
    </header>
  )
}
