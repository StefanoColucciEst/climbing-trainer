import { useNavigate } from 'react-router-dom'
import { ListItem } from '../components/ui/ListItem'

export function StatisticsPage() {
  const navigate = useNavigate()

  return (
    <div className="pt-12">
      <h1 className="text-2xl font-bold text-text mb-6">Statistics</h1>

      <ListItem
        title="Grips"
        subtitle="Hang & lift grip assessments"
        onClick={() => navigate('/statistics/grips')}
      />
      <ListItem
        title="Conditioning"
        subtitle="Pull-ups, campus board"
        onClick={() => navigate('/statistics/conditioning')}
      />
      <ListItem
        title="Technique"
        subtitle="Coming soon"
        onClick={() => navigate('/statistics/technique')}
      />
    </div>
  )
}
